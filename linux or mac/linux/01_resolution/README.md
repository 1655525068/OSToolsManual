# Hyper-v 安装CentOS7设置分辨率

```sh
root@localhost ~]# vi /boot/grub2/grub.cfg
```

找到如下几行，并追加 video=hyperv_fb:800x600，注意版本号要与进入系统前所选的版本号一致

```sh
linux16 /vmlinuz-0-rescue-81faeb6f136b472eba90921d8d066883 root=/dev/mapper/centos_miwifi--r4a--srv-root ro crashkernel=auto spectre_v2=retpoline rd.lvm.lv=centos_miwifi-r4a-srv/root rd.lvm.lv=centos_miwifi-r4a-srv/swap rhgb quiet video=hyperv_fb:1920x1080
```


## 或者直接执行：

```sh
[root@localhost ~]# grubby --update-kernel=ALL --args="video=hyperv_fb:1920x1080"
```