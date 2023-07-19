@echo off
setlocal enabledelayedexpansion

@REM ############Git ENV#############
echo Git ENV START

set SET_PATH=E:\02_environment\Git\bin
set SET_PATH_S="%SET_PATH%"



del temp_set_path.ps1
echo %PATH% | find /i %SET_PATH_S% > nul
if %errorlevel% equ 0 (
    echo UNSUCCESSFUL git evn exist %SET_PATH%

) else (
    @REM write temp_set_path.ps1
    echo [environment]::SetEnvironmentvariable("PATH", "$([environment]::GetEnvironmentvariable("Path", "User"));%SET_PATH%", "User"^) >> temp_set_path.ps1
    echo [environment]::SetEnvironmentvariable("PATH", "$([environment]::GetEnvironmentvariable("Path", "Machine"));%SET_PATH%", "Machine"^) >> temp_set_path.ps1
    @REM run temp_set_path.ps1 with
    powershell -File temp_set_path.ps1
    echo SUCCESSFUL git evn not exist and add git %SET_PATH%
    del temp_set_path.ps1

)
echo Git ENV END
pause


