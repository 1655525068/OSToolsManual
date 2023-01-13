# 如何设置里的通用-登录项-允许在后台

运行下面的命令，它会在桌面生成一个 launch.txt 的文件，把这个文件贴上来看看先：

```sh
sudo -- bash -c 'echo " - $(date) -"; while IFS= read -r eachPlist; do echo "-$eachPlist";  /usr/bin/defaults read "$eachPlist"; done <<< "$(/usr/bin/find /Library/LaunchDaemons /Library/LaunchAgents ~/Library/LaunchAgents /private/var/root/Library/LaunchAgents /private/var/root/Library/LaunchDaemons -name "*.plist")"; /usr/bin/defaults read com.apple.loginWindow LogoutHook; /usr/bin/defaults read com.apple.loginWindow LoginHook' > ~/Desktop/launch.txt

```

注：
当它提示输入password的时候，输入当前管理员账号的密码，光标不会随着输入而移动，输入完毕后，按 enter 键确认。
如果不太习惯终端命令, 可以参考视频 《把Mac终端命令用起来-命令：复制、粘贴和拖拽》
执行成功的话，应该没有提示任何信息；否则的话，会有提示，可以把提示信息提交上来进一步派错。删除后，重新启动一下下。
