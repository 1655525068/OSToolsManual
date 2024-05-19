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
