REM %4 - > porta do banco
REM %3 -> host
REM %2 -> local onde será salvo o arquivo .dump
REM %1 -> nome do banco 

"C:\Program Files\PostgreSQL\15\bin\dropdb.exe" -h %3 -U postgres %1

pause
"C:\Program Files\PostgreSQL\15\bin\createdb.exe" -E UTF8 -U postgres -h localhost -p %4 %1

pause
"C:\Program Files\PostgreSQL\15\bin\pg_restore.exe" -h %3 -p %4 -U postgres -d %1 -v %2

pause