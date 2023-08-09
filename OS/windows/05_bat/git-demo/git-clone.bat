
@echo off
SET SourceFolder=C:\1655525068\projects\
if not exist %SourceFolder% (
	mkdir %SourceFolder%
)

for /F "tokens=*" %%A in (project.txt) do (
    echo  ===== START  %%A  ========================
    cd %SourceFolder%
    git clone "https://github.com/1655525068/"%%A.git
    echo  =====  %%A   END  ========================
)


pause
