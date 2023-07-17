# scoop 包管理器的安装

## powshell（管理员）运行

```sh
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
```

## 安装包管理器

```sh
 iwr -useb get.scoop.sh | iex
```

## 设置环境变量

```sh
$env:SCOOP='E:\02_environment\Scoop'
[Environment]::SetEnvironmentVariable('SCOOP',$ENV:SCOOP,'User')
$env:SCOOP_GLOBAL='E:\02_environment\SOFTWARE\Scoop'
[Environment]::SetEnvironmentVariable('SCOOP_GLOBAL',$ENV:SCOOP_GLOBAL,'Machine')
```
