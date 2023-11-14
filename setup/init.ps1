# Set Personalize
reg add HKCU\Software\Microsoft\Windows\CurrentVersion\Themes\Personalize /v AppsUseLightTheme /t REG_DWORD /d 0 /f
reg add HKCU\Software\Microsoft\Windows\CurrentVersion\Themes\Personalize /v SystemUsesLightTheme /t REG_DWORD /d 0 /f
reg add HKCU\Software\Microsoft\Windows\CurrentVersion\Themes\Personalize /v EnableTransparency /t REG_DWORD /d 1 /f

# Set Language Change to Left Alt + Shift
reg add "HKCU\Keyboard Layout\Toggle" /v "Hotkey" /t REG_SZ /d "1" /f
reg add "HKCU\Keyboard Layout\Toggle" /v "Language Hotkey" /t REG_SZ /d "1" /f

# Enable "Let me use a different input method for each app window"
Set-WinLanguageBarOption -UseLegacySwitchMode