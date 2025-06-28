<template>
  <AddDialog @todo-created="handleTodoCreated" />
  <el-row justify="center">
    <el-col :span="24" v-for="todo in todos" :key="todo.taskId">
      <el-card class="card-content">
        <div class="card-header">
          <span class="card-title">{{ todo.title }}</span>
          <el-checkbox v-model="todo.isCompleted">Completed</el-checkbox>
        </div>
        <div class="card-footer">
          <span class="card-time"> Created At: {{ todo.createdAt }} </span>
        </div>
      </el-card>
    </el-col>
  </el-row>
</template>

<script setup lang="ts">
import { ref } from "vue";
import AddDialog from "../components/todos/AddDialog.vue";
import message from "element-plus";
// import { getPriorityLevel } from "../types/todos";
import {
  DisplayTodo,
  CreateTodoResult,
  createResult2Display,
} from "../types/todos";

const todos = ref<DisplayTodo[]>([]);

const handleTodoCreated = (result: CreateTodoResult) => {
  if (result && Object.keys(result).length > 0) {
    try {
      var todo = createResult2Display(result);
      todos.value.push(todo);

      // 成功提示
      // message.success("待办事项创建成功");
    } catch (error) {
      console.error("处理创建结果时出错：", error);
    }
  } else {
    console.warn("创建待办事项返回了无效结果");
    // message.warning('创建待办事项可能未成功');
  }
};
</script>

<style scoped>
.card-content {
  display: flex;
  flex-direction: column;
  width: 350px;
  height: 100px;
  justify-content: space-between;
  margin: 0 auto;
  margin-bottom: 10px;
}

.card-header {
  display: flex;
  justify-content: space-between;
  justify-items: flex-start;
  margin-bottom: 16px;
}

.card-title {
  font-weight: bold;
  font-size: 18px;
}

.card-footer {
  display: flex;
  justify-items: flex-end;
}

.card-time {
  font-size: 12px;
  color: #888;
}
</style>
