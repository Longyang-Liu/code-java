import Vue from 'vue'

export function newMessage(type, message, closeFlag){
  Vue.prototype.$message({
    type: type, message: message, showClose: closeFlag == false ? false : true,
  })
}

// export async function handleDelete() {
//   await Vue.prototype.$confirm('删除操作不可逆，是否继续', "警告", {
//     confirmButtonText: "确定",
//     cancelButtonText: "取消",
//     type: "warning"
//   }).then(function() {
//     return true;
//   })
// }