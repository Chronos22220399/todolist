import { createApp } from "vue";
import "./style.css";
import App from "./App.vue";

// 1. 引入 Element Plus 及样式
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";

// 2. 引入 Pinia
import { createPinia } from "pinia";

// 3. 引入 Router
import router from "./router/";

// 4. 创建 Vue 应用示例
const app = createApp(App);

// 5. 挂载插件
app.use(ElementPlus);
app.use(createPinia());
app.use(router);

// 6. 挂载页面
app.mount("#app");
