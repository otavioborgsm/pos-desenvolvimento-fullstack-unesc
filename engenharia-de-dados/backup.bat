REM %4 - > porta do banco
REM %3 -> host
REM %2 -> local onde será salvo o arquivo .dump
REM %1 -> nome do banco 

"C:\Program Files\PostgreSQL\15\bin" -h %3 -p %4 -U postgres -F c -b -v -f %2 %1

pause