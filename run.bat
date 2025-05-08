@echo off
echo [1] Compiling...
javac -cp "lib/mysql-connector-j-9.3.0.jar" -d bin src\*.java

if %ERRORLEVEL% NEQ 0 (
    echo [!] Compile failed.
    pause
    exit /b
)

echo [2] Running...
java -cp "bin;lib/mysql-connector-j-9.3.0.jar" Main

pause
