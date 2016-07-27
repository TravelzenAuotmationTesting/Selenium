rmdir /s/q bin
mkdir \a bin
dir /s/b *.java>sourcelist
javac -d bin @sourcelist
xcopy /e configuration bin

pause