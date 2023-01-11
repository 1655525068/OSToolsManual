# homebrew 安装jdk

切换homebrew源

```sh
cd "$(brew --repo)"
git remote set-url origin https://mirrors.aliyun.com/homebrew/brew.git
cd "$(brew --repo)/Library/Taps/homebrew/homebrew-core"
git remote set-url origin https://mirrors.aliyun.com/homebrew/homebrew-core.git

brew update

```

## #设置环境变量  以zsh为例
```sh
echo 'export HOMEBREW_BOTTLE_DOMAIN=https://mirrors.aliyun.com/homebrew/homebrew-bottles' >> ~/.zshrc
source ~/.zshrc
```

## 恢复下载源

```sh

cd "$(brew --repo)"
git remote set-url origin https://github.com/Homebrew/brew.git

cd "$(brew --repo)/Library/Taps/homebrew/homebrew-core"
git remote set-url origin https://github.com/Homebrew/homebrew-core.git

brew update
```

需要把 ~/.zshrc 中的 HOMEBREW_BOTTLE_DOMAIN 环境变量删除
执行

```sh
source ~/.zshrc
```

## 搜索jdk版本

```sh
brew search openjdk
```

```sh
==> Formulae
openjdk      openjdk@11   openjdk@17   openjdk@8    openj9       openvdb

==> Casks
adoptopenjdk               microsoft-openjdk          openkey
```

## 安装jdk11

···sh
brew install openjdk@11
```

```sh
==> Fetching dependencies for openjdk@11: giflib, libpng, freetype, fontconfig, pcre2, gettext, glib, xorgproto, libxau, libxdmcp, libxcb, libx11, libxext, libxrender, lzo, pixman, cairo, graphite2, icu4c, harfbuzz, jpeg-turbo, lz4, xz, zstd, libtiff and little-cms2
...
...
==> openjdk@11
For the system Java wrappers to find this JDK, symlink it with
  sudo ln -sfn /opt/homebrew/opt/openjdk@11/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-11.jdk
```

## 安装jdk17





## 安装jenv 切换jdk

```sh
brew install jenv
```


## 配置bash_profile
```sh
vim ~/.bash_profile
```

### 添加
```sh
export JAVA_11_HOME=/Library/Java/JavaVirtualMachines/openjdk-11.jdk
export JAVA_18_HOME=/Library/Java/JavaVirtualMachines/openjdk-17.jdk
export JAVA_HOME=$JAVA_11_HOME

alias jdk11="export JAVA_HOME=$JAVA_11_HOME"
alias jdk17="export JAVA_HOME=$JAVA_17_HOME"

export PATH="$HOME/.jenv/bin:$PATH"
eval "$(jenv init -)"
```
### 执行文件bash_profile
```sh
source ~/.bash_profile
```


## 在zsh中执行
在~/下创建./zshrc 文件，在文件里添加source ~/.bash_profile命令

### 查看环境版本
```sh
jenv versions
jenv local 11.0
java -version
```

查看切换后的版本
```sh
java -version
echo $JAVA_HOME
```

```sh
openjdk version "11.0.17" 2022-10-18
OpenJDK Runtime Environment Homebrew (build 11.0.17+0)
OpenJDK 64-Bit Server VM Homebrew (build 11.0.17+0, mixed mode)
```
