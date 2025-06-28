<template>
  <div>
    <!-- add button -->
    <el-button type="primary" @click="showDialog = true"> Add Todo </el-button>
    <!-- add dialog -->
    <el-dialog title="Add Todo" v-model="showDialog" width="400px" @close="resetForm">
      <el-form :model="form">
        <!-- title -->
        <el-form-item label="Title">
          <el-input v-model="form.title" />
        </el-form-item>
        <!-- description -->
        <el-form-item label="Description">
          <el-input v-model="form.description" />
        </el-form-item>
        <!-- category -->
        <div class="padding-between-select">
          <el-select v-model="form.categoryId" placeholder="Select Task Category">
            <el-option v-for="category in categoryOptions" :key="category.categoryId" :label="category.name"
              :value="category.categoryId" />
          </el-select>
        </div>

        <!-- priority -->
        <el-select v-model="form.priority" placeholder="Select Priority">
          <el-option v-for="priority in priorityOptions" :key="priority.value" :label="priority.label"
            :value="priority.value" />
        </el-select>
      </el-form>

      <template #footer>
        <el-button @click="showDialog = false">Cancel</el-button>
        <el-button type="primary" @click="submit">Submit</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted, defineEmits } from "vue";
import { ElSelect, ElOption } from "element-plus";
import { getCategories } from "../../api/categories";
import { Category } from "../../types/categories";
import { createTodo } from "../../api/todos";
import type { CreateTodoData, CreateTodoResult } from "../../types/todos";
import { priorityOptions } from "../../types/todos";

const showDialog = ref(false);

const form = ref<CreateTodoData>({
  title: "",
  categoryId: 0,
  description: "",
  priority: 0,
  createdBy: 0,
});

// todo 种类选项，通过 onMounted 从后端获取
const categoryOptions = ref<Category[]>([]);

const emit = defineEmits<{
  "todo-created": [todo: CreateTodoResult];
  update: [];
}>();

const submit = async () => {
  try {
    const res = await createTodo(form.value);
    // 发射事件通知父组件
    emit("todo-created", res);
    emit("update");

    resetForm();
  } catch (error) {
    console.error("创建失败: ", error);
  }
};

const resetForm = () => {
  form.value.categoryId = 0;
  form.value.title = "";
  form.value.description = "";
  form.value.priority = 0;
  form.value.createdBy = 0;
};

onMounted(async () => {
  const res = await getCategories(0);
  categoryOptions.value = res;
});
</script>

<style>
.padding-between-select {
  padding-bottom: 10px;
}
</style>
