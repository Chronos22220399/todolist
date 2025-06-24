# STEP2: 根据表单对项目内容进行基础构建
> 这里的基础内容指具体业务之外的后端部分的内容

## 详细待办

### 1. 编写 MyBatis-Plus 实体类
- 每张表写对应的 Java 实体类（使用 JPA 或 MyBatis-Plus 注解）
> 在 `custom/` 目录下创建 `CatogoryCode.java`、`Role.java`、`TaskPriority.java`、`TaskStatus.java` 等类型保证类型安全
> 分别在 `entity/` 目录下创建 `User.java`、`Todos.java`、`TaskCatogories.java` 等实体类

### 2. 编写 Mapper 接口
- 为每个实体类写 Mapper（MyBatis-Plus），声明基础的 CRUD 操作

