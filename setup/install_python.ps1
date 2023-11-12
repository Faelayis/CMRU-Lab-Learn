$pythonVersion = "3.12.0"
$url = "https://www.python.org/ftp/python/$pythonVersion/python-$pythonVersion-amd64.exe"
$installerPath = "$env:TEMP\python-installer.exe"

$isAdmin = ([Security.Principal.WindowsPrincipal] [Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole([Security.Principal.WindowsBuiltInRole]::Administrator)

if (-not $isAdmin) {
   Start-Process powershell -ArgumentList "-NoProfile -ExecutionPolicy Bypass -Command `"& { Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://raw.githubusercontent.com/Faelayis/CMRU-Lab-Learn/main/setup/install_python.ps1')) }`"" -Verb RunAs
   exit
}

try {
   Write-Host "Downloading Python installer from $url..."
   Invoke-WebRequest -Uri $url -OutFile $installerPath -ErrorAction Stop -UseBasicParsing

   Write-Host "Installing..."
   Start-Process -FilePath $installerPath -ArgumentList "/quiet", "InstallAllUsers=1", "PrependPath=1", "Include_test=0" -Wait -ErrorAction Stop
}
catch {
   Write-Host "Error: $_"
}
finally {
   Write-Host "Installation Python Completed Successfully."
   Remove-Item $installerPath -ErrorAction SilentlyContinue
   Pause
}
