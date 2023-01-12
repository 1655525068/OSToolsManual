# homebrew 安装 node

```sh
brew install node
```

## 查询安装状态

```sh
wangbochen@MacBook-Pro-14 ~ % node -v
v19.4.0
wangbochen@MacBook-Pro-14 ~ % npm -version
9.2.0
wangbochen@MacBook-Pro-14 ~ % npm  
```

## 查看当前源地址

```sh
wangbochen@MacBook-Pro-14 ~ % npm config get registry

https://registry.npmjs.org/
```

## 安装nrm（管理源地址工具）

```sh
npm install nrm -g
```

使用 nrm -V 查看版本，以及是否安装成功

```sh
wangbochen@MacBook-Pro-14 ~ % nrm -V
1.2.5
```

源地址列表

```sh
wangbochen@MacBook-Pro-14 ~ % nrm ls

  npm ---------- https://registry.npmjs.org/
  yarn --------- https://registry.yarnpkg.com/
  tencent ------ https://mirrors.cloud.tencent.com/npm/
  cnpm --------- https://r.cnpmjs.org/
  taobao ------- https://registry.npmmirror.com/
  npmMirror ---- https://skimdb.npmjs.com/registry/
```

## 切换taobao镜像源

```sh
nrm use taobao
```

### 查看切换后源地址

```sh
npm config get registry

https://registry.npmmirror.com/
```

代替npm工具---yarn

```sh
npm install yarn -g
```
