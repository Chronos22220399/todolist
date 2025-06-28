import axios from "./axios";
import { Category } from "../types/categories"

export async function getCategories(userId: number): Promise<Category[]> {
  const categories = await axios.get<Category[]>(`/api/users/${userId}/categories`);
  console.log(categories)
  return categories.data;
}
