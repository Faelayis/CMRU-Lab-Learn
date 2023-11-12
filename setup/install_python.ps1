$pythonVersion = "3.12.0"
$url = "https://www.python.org/ftp/python/$pythonVersion/python-$pythonVersion-amd64.exe"
$installerPath = "$env:TEMP\python-installer.exe"

try {
   Invoke-WebRequest -Uri $url -OutFile $installerPath -ErrorAction Stop -UseBasicParsing
   Start-Process -FilePath $installerPath -ArgumentList "/quiet", "InstallAllUsers=1", "PrependPath=1", "Include_test=0" -Wait -ErrorAction Stop
}
catch {
   Write-Host "Error: $_"
}
finally {
   Remove-Item $installerPath -ErrorAction SilentlyContinue
}
