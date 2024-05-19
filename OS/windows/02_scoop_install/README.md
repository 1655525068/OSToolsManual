# scoop 包管理器的安装

## powshell（管理员）运行

```sh
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
```

## 安装包管理器

```sh
 iwr -useb get.scoop.sh | iex
```


Scoop安装遇到 “raw.githubusercontent.com未能解析” 解决方案

```sh
iex "& {$(irm get.scoop.sh)} -RunAsAdmin"
```



## 设置环境变量

```sh
mkdir E:\01_environment\Scoop\shims
$env:SCOOP='E:\01_environment\Scoop'
[Environment]::SetEnvironmentVariable('SCOOP',$ENV:SCOOP,'User')
$env:SCOOP_GLOBAL='E:\01_environment\SOFTWARE\Scoop'
[Environment]::SetEnvironmentVariable('SCOOP_GLOBAL',$ENV:SCOOP_GLOBAL,'Machine')
```


（第一次在电脑安装时，执行完本节内容，可跳过1.2节内容。）

打开Windows Powershell界面（开始菜单右键）

# 脚本执行策略更改
Set-ExecutionPolicy RemoteSigned -scope CurrentUser
# 输入Y或A，同意
Y
# 执行安装命令（默认安装在用户目录下，如需更改请执行“自定义安装目录”命令）
iwr -useb scoop.201704.xyz | iex


## 自定义安装目录（注意将目录修改为合适位置)
irm scoop.201704.xyz -outfile 'install.ps1'
.\install.ps1 -ScoopDir 'D:\Scoop' -ScoopGlobalDir 'D:\GlobalScoopApps'
1.2 已安装scoop,更换镜像
（适用于已安装官方源或其他镜像地址的人使用)

# 更换scoop的repo地址
scoop config SCOOP_REPO "https://gitee.com/scoop-installer/scoop"
# 拉取新库地址
scoop update
