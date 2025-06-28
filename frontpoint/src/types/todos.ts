// 优先级选项，用于映射优先级
export enum Priority {
  LOW = 0,
  MIDDLE = 1,
  HIGH = 2
}

export type PriorityLabel = 'priority-high' | 'priority-middle' | 'priority-low';

export interface PriorityOption {
  value: Priority;
  label: PriorityLabel;
};

export const priorityOptions: PriorityOption[] = [
  { value: Priority.HIGH, label: "priority-high" },
  { value: Priority.MIDDLE, label: "priority-middle" },
  { value: Priority.LOW, label: "priority-low" }
];

export const getPriorityLevel = (value: number): string => {
  const option = priorityOptions.find((opt => opt.value === value));
  return option?.label || "unknown-priority" as PriorityLabel;
};

export interface DisplayTodo {
  taskId: number;
  title: string;
  category: string;
  description: string;
  priority: string;
  createdAt: Date;
  isCompleted: boolean;
}

export interface CreateTodoData {
  title: string;
  categoryId: number;
  description: string;
  priority: number;
  createdBy: number;
}


export interface CreateTodoResult {
  taskId: number;
  title: string;
  category: string;
  description: string;
  status: string;
  priority: number;
  createdAt: Date;
  updatedAt: Date;
  isCompleted: boolean;
}

export function createResult2Display(result: CreateTodoResult): DisplayTodo {
  const todo: DisplayTodo = {
    ...result,
    priority: getPriorityLevel(result.priority),
  };
  return todo;
}
