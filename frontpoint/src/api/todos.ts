import axios, { isAxiosError } from "axios";
import { parseISO } from "date-fns";
import type { CreateTodoData, CreateTodoResult } from "../types/todos.ts"
import { HttpStatus } from "../types/httpStatus"
import { ApiResult } from "../types/apiResult";

interface CreateTodoResponse {
	taskId: number;
	title: string;
	category: string;
	description: string;
	status: string;
	priority: number;
	createdAt: string;
	updatedAt: string;
	isCompleted: boolean;
}

/**
 * 创建待办事项
 * @param todoBasicInfo 待办事项基础信息
 * @returns 创建成功的待办事项信息
 * @throws Error 创建失败时抛出错误
 */
export async function createTodo(todoBasicInfo: CreateTodoData): Promise<CreateTodoResult> {
	try {
		const response = await axios.post<ApiResult<CreateTodoResponse>>("/api/todos", todoBasicInfo);

		const apiResult = response.data;

		if (apiResult.statusCode !== HttpStatus.CREATED) {
			if (apiResult.error) {
				throw new Error(`API错误: ${apiResult.error.error} - ${apiResult.error.details}`);
			}
			throw new Error(`预期状态码 ${HttpStatus.CREATED}，但收到 ${apiResult.statusCode}`);
		}

		if (!response.data) {
			throw new Error("服务器返回了成功状态码，但没有包含数据");
		}

		// 展开语法糖
		return {
			...apiResult.data,
			createdAt: parseISO(apiResult.data.createdAt),
			updatedAt: parseISO(apiResult.data.updatedAt),
		}
	} catch (error) {
		if (axios.isAxiosError(error)) {
			const apiResult = error.response?.data as ApiResult<unknown> | undefined;

			if (apiResult?.error) {
				throw new Error(`创建待办事项失败: ${apiResult.error.error} - ${apiResult.error.details}`);
			} else {
				throw new Error(`创建待办事项失败: ${error.message}`);
			}
		}
		// 处理其他类型错误
		throw error instanceof Error
			? error
			: new Error(`创建待办事项时发生未知错误: ${String(error)}`);
	}
}
