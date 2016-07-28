rmdir /s/q bin
mkdir bin
dir /s/b *.java>sourcelist
javac -d bin @sourcelist
xcopy /e configuration bin

pause