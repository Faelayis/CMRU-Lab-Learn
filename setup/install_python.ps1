$pythonInstalled = Get-Command python -ErrorAction SilentlyContinue
$pythonVersion = "3.12.0"
$url = "https://www.python.org/ftp/python/$pythonVersion/python-$pythonVersion-amd64.exe"
$installerPath = "$env:TEMP\python-installer.exe"

$isAdmin = ([Security.Principal.WindowsPrincipal] [Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole([Security.Principal.WindowsBuiltInRole]::Administrator)

if (-not $isAdmin) {
   Start-Process powershell -ArgumentList "-NoProfile -ExecutionPolicy Bypass -Command `"& { Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://raw.githubusercontent.com/Faelayis/CMRU-Lab-Learn/main/setup/install_python.ps1')) }`"" -Verb RunAs
   exit
}

function ExtractMajorMinorVersion {
   param (
      [string]$version
   )

   $versionComponents = $version -split '\.'
   $majorMinorVersion = $versionComponents[0] + '.' + $versionComponents[1]
   return $majorMinorVersion
}

function Exiting {
   param (
      [int]$time
   )

   Write-Host ""
   Write-Host "Exiting in $time seconds..."
   Start-Sleep -Seconds $time
   exit
}

function InstallPython {
   try {
      Write-Host "Downloading Python installer from $url..."
      Invoke-WebRequest -Uri $url -OutFile $installerPath -ErrorAction Stop -UseBasicParsing
      Write-Host ""
      Write-Host "Installing..."
      Start-Process -FilePath $installerPath -ArgumentList "/quiet", "InstallAllUsers=1", "PrependPath=1", "Include_test=0" -Wait -ErrorAction Stop
   }
   catch {
      Write-Host "Error: $_"
      Pause
   }
   finally {
      Write-Host "Installation Python $pythonVersion completed."
      Remove-Item $installerPath -ErrorAction SilentlyContinue
      Exiting -time 5
   }
}

if ($pythonInstalled) {
   $installedMajorMinorVersion = ExtractMajorMinorVersion -version $($pythonInstalled.Version)
   $pythonMajorMinorVersion = ExtractMajorMinorVersion -version $pythonVersion

   if ($installedMajorMinorVersion -eq $pythonMajorMinorVersion) {
      Write-Host "Python $pythonVersion is installed."
      Exiting -time 5
   }
   else {
      Write-Host "Python version $installedMajorMinorVersion is installed, but version $pythonMajorMinorVersion is required."
      InstallPython
   }
}
else {
   Write-Host "Python is not installed."
   InstallPython
}