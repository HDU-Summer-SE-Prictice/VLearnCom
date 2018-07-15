#!/bin/bash

# 备份 vlearncom 数据库的数据
mysqldump -ucj -p123 vlearncom --hex-blob > vlearncom-data.sql
