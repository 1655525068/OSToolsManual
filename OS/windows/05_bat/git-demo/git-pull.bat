
@echo off
SET SourceFolder=C:\1655525068\projects\
if not exist %SourceFolder% (
	mkdir %SourceFolder%
)

for /F "tokens=*" %%A in (project.txt) do (
    echo  ===== START  %%A  ========================
    cd %SourceFolder%%%A
    for /f "delims=" %%t in ('git symbolic-ref --short -q HEAD') do set str=%%t
    git pull origin %str%
    echo  =====  %%A   END  ========================
)



pause