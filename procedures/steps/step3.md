# STEP3: 业务分析与编码

## 业务分析

### 简写说明:
#### 自定义说明
1. input: 用户输入
2. select: 菜单选择
3. ?: 表示是可选项
4. dft: 默认
5. sys_ctd: 系统自动生成
6. sys_set: 系统设置（程序员设置）
7. error and error details: 指如下的json
      ```json
      {
        "error": "xxx",
        "details": {
          "xxx": "xxx"
        }
      }
      ```


#### REST API 说明
1. 创建（POST）
  - 成功: 
    - status: 201 Created
    - body: Resources.self
  - 失败:
    - status: 4xx（取决与错误类型）/ 500  Internal Server Error
    - body: error and error details

2. 查询（GET）
  - 成功:
    - status: 200 OK
    - body: Resources.self
  - 失败:
    - status: 404 Not Found / 500 Internal Server Error
    - body: error and error details?

3. 更新（PUT/PATCH）
  - 成功:
    - status: 200 OK / 204 No Content（有的接口会返回更新后的对象、有的不会）
    - body: Resources.self?
  - 失败:
    - status: 4xx / 500 Internal Server Error
    - body: error and error details
    
4. 删除（DELETE）
  - 成功:
    - status: 204 No Content（一般不返回 body）
  - 失败:
    - status: 404 Not Found / 500 Internal Server Error
    - body: error and error details?

### Todo
1. 创建任务
- 接收:
  - title: str - input
  - catogory_id: int - select
  - description: str - input? dft: ""
  - priority: int - input? dft: 0
  - created_by: int - sys_ctd(current_user_id)

- 返回:
  - 成功:
    - status_code: 200 OK
    - todo: TodoVO
  - 失败:
    - status_code: 4xx / 500 Internal Server Error
    - error and error details

2. 分页查询任务
- 接收:
  - page: int - select dft: 0 
  - offset: int - sys_set dft: 5

- 返回
  - 成功: 
    - status_code: 200 OK
    - todos: List<TodoVO>
  - 失败:
    - status_code: 404 Not Found / 500 Internal Server Error
    - error and error details?

3. 删除任务
- 接收:
  - task_id: int - select
  
- 返回:
  - 成功:
    - status_code: 204 No Content
  - 失败:
    - status_code: 404 Not Found / 500 Internal Server Error
    - error and error details?

4. 更新
- 接收:
  - task_id: int - select
  - others 

- 返回:
    - status: 200 OK 
    - body: TodoVO 
  - 失败:
    - status: 4xx / 500 Internal Server Error
    - body: error and error details
    
5. 查询任务详情
-- TODO: 待办 --


## 业务编码
### 1. DTO/VO 类
- 编写用于参数接收和返回的 DTO/VO 类，分离接口和实体

### 2. Service 层
- 编写 Service 接口和实现类，处理业务逻辑

