# Windows11 安装遇到各种问题

## 1.powershell（管理员）运行下列指令，强制绕过 TPM、RAM、内存、CPU 等检查

```sh
reg add “HKLM\SYSTEM\Setup\LabConfig” /v “BypassTPMCheck” /t REG_DWORD /d “1” /f
reg add “HKLM\SYSTEM\Setup\LabConfig” /v “BypassSecureBootCheck” /t REG_DWORD /d “1” /f
reg add “HKLM\SYSTEM\Setup\LabConfig” /v “BypassRAMCheck” /t REG_DWORD /d “1” /f
reg add “HKLM\SYSTEM\Setup\LabConfig” /v “BypassStorageCheck” /t REG_DWORD /d “1” /f
reg add “HKLM\SYSTEM\Setup\LabConfig” /v “BypassCPUCheck” /t REG_DWORD /d “1” /f
reg add “HKLM\SYSTEM\Setup\MoSetup” /v “AllowUpgradesWithUnsupportedTPMOrCPU” /t REG_DWORD /d “1” /f
```

## 2.替换 sources 中的 appraiserres.dll 文件

### appraiserres.dll 文件是 Windows10 的检查文件，替换 Windows11 中的安装环境后即可解决

[appraiserres.dll 下载](https://github.com/1655525068/OSToolsManual/raw/main/windows/00_windows_install/dll/appraiserres.dll)

- 替换路径:Win11_xxxx_xxxxxxxx_Simplified_x64v1>sources>appraiserres.dll

```sh
您对该软件的使用受您为获得该软件而签订的许可协议的条款和条件的约束。如果您是批量许可客户，则您对该软件的使用应受批量许可协议的约束。如果您未从 Microsoft 或其许可的分销商处获得该软件的有效许可，则不得使用该软件。
```
