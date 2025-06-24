# STEP4: 实现全局异常处理和服务

## 全局异常处理
### 详述
项目的 API 均返回 `ApiResult`，其内部结构如下：

- **`status code`**: 内容与 HTTP 响应头部的状态码相同。
- **`error`**: 可选值，与 `data` 互斥。当 `data` 存在时，`error` 为空。`error` 内部包含：
  - 错误码：根据业务定义。
  - 错误详细信息。
- **`data`**: 返回的具体数据。

全局异常处理的相关内容：

- 异常处理类存放于 `exception/` 目录下的 `GlobalException` 文件中。
- 使用 `@RestControllerAdvice` 统一注册全局异常处理。
- 默认处理以下异常：
  - **`BusinessException`**: 业务异常，统一通过 `BusinessException` 处理。
  - **`MethodArgumentNotValidException`**: 方法参数校验异常。
  - **`Exception`**: 通用异常。

#### ApiResult 定义
```java
@Data
public class ApiResult<T> {
  // HTTP 状态码
  private Integer statusCode;
  // 错误详情
  private Optional<ErrorInfo> error = Optional.empty();
  // 成功数据
  private T data;
  
  @Data
  public static class ErrorInfo {
    // 业务错误码/类型
    private String error;
    // 错误详情
    private String details;
  }
}
```

> 上述的错误码与 Error 内的错误码对应

#### Error 定义
Error 描述了业务范围内的各种错误，用于锁定错误以 debug
```java
public enum Error {

  NOT_FOUND("NOT_FOUND", "资源未找到"),
  USER_EXISTS("USER_EXISTS", "用户名已存在"),
  INTERNAL_ERROR("INTERNAL_ERROR", "服务器内部错误"),
  VALIDATION_ERROR("VALIDATION_ERROR", "验证失败");
  ...

  private final String code;
  private final String defaultMessage;

  Error(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
```


#### BusinessException 定义
BusinessException 内的定义与 `Error` 相对应，errorCode 对应 code，message 对应 message

```java
public class BusinessException extends RuntimeException {

  private final String errorCode;

  public BusinessException(String errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  public BusinessException(Error e) {
    super(e.getDefaultMessage());
    this.errorCode = e.getCode();
  }

  public String getErrorCode() {
    return errorCode;
  }
}
```


### 5. Controller 层
- 编写 RestController，定义接口路由和请求处理

### 6. 全局异常处理
- 写一个统一的异常处理器（@ControllerAdvice）

### 7. 参数校验
- 使用 javax.validation 注解标注 DTO 字段，并在 Controller 层加 @Valid 校验

---

### 8. 接口文档
- 配置 Swagger/OpenAPI，自动生成接口文档

### 9. 安全认证（登录注册）
- 配置 Spring Security，实现用户注册、登录、鉴权（可先用内存用户或简单 JWT）

### 10. 单元测试
- 写简单的 Controller、Service 层单元测试

