@echo off
setlocal enabledelayedexpansion

@REM Judge the administrator
net session > nul 2>&1
if %errorlevel% equ 0 (
    @REM administrator
    echo administator
    @REM run 01_git_env
    Call 01_git_env
) else (
    echo Please use administrator to execute
)

pause