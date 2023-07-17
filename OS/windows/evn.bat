@echo off
@REM 管理员运行cmd
@REM Git环境变量
[environment]::SetEnvironmentvariable("PATH", "$([environment]::GetEnvironmentvariable("Path", "User"));E:\02_environment\Git\bin", "User")
[environment]::SetEnvironmentvariable("PATH", "$([environment]::GetEnvironmentvariable("Path", "Machine"));E:\02_environment\Git\bin", "Machine")
@REM Git证书
git config --system http.sslcainfo "E:\02_environment\Git\mingw64\ssl\certs\ca-bundle.crt"
git config --system http.sslverify false

