import os

def copy_file(src_file,target_file):
    """
    Args:
    src_file:源文件路径
    target_file:目标文件路径
    """
    with open(src_file,'rb') as f:
        content = f.read()
    with open(target_file,'wb') as f:
        f.write(content)

print("setting the vscode background")

# 1. 找到vscode安装目录，Code.exe的父级路径
vscode_install_path = r'C:\tools\Microsoft VS Code'
css_part_path = r'resources\app\out\vs\workbench'  # .css 所在部分目录
css_file = os.path.join(vscode_install_path, css_part_path, 'workbench.desktop.main.css')
print(css_file)

# 2. 选择要作为背景的图片
src_file = r'C:\Users\bochen.wang\Pictures\picture\background2.png'
# 要添加的样式
body_ = "\nbody{background-size: 35%;background-repeat: no-repeat;background-position: right bottom;opacity: 0.6;image-rendering: pixelated; background-image: url('my-background.png');}\n"
# 3. 将图片复制到vscode路径下并修改.css文件
src_ext = os.path.basename(src_file).split('.')[-1]  # 源文件扩展名
allow_ext = ['jpg', 'jepg', 'webp', 'png']
if not ((src_ext.lower() in allow_ext) and (os.path.exists(src_file) and os.path.isfile(src_file))):
    print('The selected background image file does not meet the requirements{}Or not exist'.format(allow_ext))
else:
    target_file = os.path.join(vscode_install_path, css_part_path, 'my-background.' + src_ext)  # 复制后的文件路径
    copy_file(src_file, target_file)
    if not os.path.exists(target_file):
        print('Background image copy failed, please try again!')
    else:
        # 先备份一下
        css_file_bak = os.path.join(vscode_install_path, css_part_path, 'workbench.desktop.main_bak.css')
        copy_file(css_file, css_file_bak)
        if not os.path.exists(css_file_bak):
            print('Source css file backup failed, background modification terminated, please try again!')
        else:
            with open(css_file, 'a', encoding='utf-8') as f:
                # 在文件末尾追加写入body设置
                f.write(body_)
            print('The vscode background is changed, please restart vscode')