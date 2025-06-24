#!/bin/bash

API_URL="http://localhost:8080/api/todo"

curl -X POST "$API_URL" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "测试任务标题",
    "categoryId": 1,
    "description": "这是一个测试任务描述",
    "priority": 1,
    "createdBy": 1
  }'
