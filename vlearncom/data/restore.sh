#!/bin/bash

# 用 vlearncom-data.sql 恢复 vlearncom 数据库
mysql -ucj -p123 vlearncom < vlearncom-data.sql
