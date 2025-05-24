/**
 * 智能制造存储中心系统 - 自定义确认对话框
 */
class ConfirmDialog {
  constructor(options = {}) {
    this.options = Object.assign({
      title: '确认操作',
      message: '确定要执行此操作吗？',
      confirmText: '确定',
      cancelText: '取消',
      confirmClass: 'btn-danger',
      cancelClass: 'btn-secondary',
      backdrop: true,
      centered: true,
      onConfirm: () => {},
      onCancel: () => {}
    }, options);
    
    this.element = null;
    this.init();
  }
  
  init() {
    // 创建对话框元素
    this.element = document.createElement('div');
    this.element.className = 'custom-confirm-dialog';
    
    // 创建对话框内容
    const content = document.createElement('div');
    content.className = 'custom-confirm-content';
    
    // 创建对话框标题
    const header = document.createElement('div');
    header.className = 'custom-confirm-header';
    
    const icon = document.createElement('i');
    icon.className = 'fas fa-exclamation-triangle';
    
    const title = document.createElement('h4');
    title.textContent = this.options.title;
    
    header.appendChild(icon);
    header.appendChild(title);
    
    // 创建对话框消息
    const message = document.createElement('div');
    message.className = 'custom-confirm-message';
    message.textContent = this.options.message;
    
    // 创建对话框按钮
    const actions = document.createElement('div');
    actions.className = 'custom-confirm-actions';
    
    const cancelBtn = document.createElement('button');
    cancelBtn.className = `btn ${this.options.cancelClass}`;
    cancelBtn.textContent = this.options.cancelText;
    cancelBtn.addEventListener('click', () => {
      this.hide();
      this.options.onCancel();
    });
    
    const confirmBtn = document.createElement('button');
    confirmBtn.className = `btn ${this.options.confirmClass}`;
    confirmBtn.textContent = this.options.confirmText;
    confirmBtn.addEventListener('click', () => {
      this.hide();
      this.options.onConfirm();
    });
    
    actions.appendChild(cancelBtn);
    actions.appendChild(confirmBtn);
    
    // 组装对话框
    content.appendChild(header);
    content.appendChild(message);
    content.appendChild(actions);
    this.element.appendChild(content);
    
    // 点击背景关闭对话框
    if (this.options.backdrop) {
      this.element.addEventListener('click', (e) => {
        if (e.target === this.element) {
          this.hide();
          this.options.onCancel();
        }
      });
    }
    
    // 添加到文档
    document.body.appendChild(this.element);
  }
  
  show() {
    // 显示对话框
    setTimeout(() => {
      this.element.classList.add('show');
    }, 10);
    
    // 添加键盘事件
    document.addEventListener('keydown', this.handleKeyDown.bind(this));
  }
  
  hide() {
    // 隐藏对话框
    this.element.classList.remove('show');
    
    // 移除键盘事件
    document.removeEventListener('keydown', this.handleKeyDown.bind(this));
    
    // 延迟后移除DOM元素
    setTimeout(() => {
      if (this.element && this.element.parentNode) {
        this.element.parentNode.removeChild(this.element);
      }
    }, 300);
  }
  
  handleKeyDown(e) {
    // ESC键关闭对话框
    if (e.key === 'Escape') {
      this.hide();
      this.options.onCancel();
    }
    
    // Enter键确认
    if (e.key === 'Enter') {
      this.hide();
      this.options.onConfirm();
    }
  }
}

console.log('Confirm dialog script loaded');

// 全局确认对话框函数
window.confirmDelete = function(message, callback) {
  console.log('confirmDelete called with message:', message);
  const dialog = new ConfirmDialog({
    title: '确认删除',
    message: message,
    confirmText: '删除',
    confirmClass: 'btn-danger',
    onConfirm: callback
  });
  
  dialog.show();
};

// 提交确认
window.confirmSubmit = function(message, callback) {
  console.log('confirmSubmit called with message:', message);
  const dialog = new ConfirmDialog({
    title: '确认提交',
    message: message,
    confirmText: '提交',
    confirmClass: 'btn-primary',
    onConfirm: callback
  });
  
  dialog.show();
};

// 通用确认对话框
window.confirmAction = function(message, callback, options = {}) {
  console.log('confirmAction called with message:', message);
  const dialog = new ConfirmDialog({
    message: message,
    onConfirm: callback,
    ...options
  });
  
  dialog.show();
}; 