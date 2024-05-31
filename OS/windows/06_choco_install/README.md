# chocolate 安装
## 用powershell 输入以下命令

```sh
$env:ChocolateyInstall='E:\01_environment\Chocolatey'
[Environment]::SetEnvironmentVariable('ChoclosteyInstall',$env:ChocolateyInstall,'Machine')
Set-ExecutionPolicy Bypass -Scope Process -Force;iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))

```
