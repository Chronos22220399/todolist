import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', {
  state: () => ({
    username: '',
    // 其它状态
  }),
  actions: {
    setUsername(name: string) {
      this.username = name
    }
  }
})    