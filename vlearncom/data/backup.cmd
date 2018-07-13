:: 备份 vlearncom 数据库的数据。运行时请将第一串修改成你的 mysqldump.exe 的路径
"C:\Program Files\MariaDB 10.3\bin\mysqldump.exe" -ucj -p123 vlearncom --hex-blob > vlearncom-data.sql