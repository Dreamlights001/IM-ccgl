/**
 * 智能制造仓储管理系统 - 主JavaScript文件
 */

document.addEventListener('DOMContentLoaded', function() {
    // 侧边栏切换
    const sidebarToggle = document.getElementById('sidebar-toggle');
    const mobileSidebarToggle = document.getElementById('mobile-sidebar-toggle');
    const sidebar = document.querySelector('.sidebar');
    const content = document.querySelector('.content');
    
    if (sidebarToggle) {
        sidebarToggle.addEventListener('click', function() {
            sidebar.classList.toggle('collapsed');
            content.classList.toggle('expanded');
            
            const icon = sidebarToggle.querySelector('i');
            if (icon) {
                if (sidebar.classList.contains('collapsed')) {
                    icon.classList.remove('fa-chevron-left');
                    icon.classList.add('fa-chevron-right');
                } else {
                    icon.classList.remove('fa-chevron-right');
                    icon.classList.add('fa-chevron-left');
                }
            }
        });
    }
    
    if (mobileSidebarToggle) {
        mobileSidebarToggle.addEventListener('click', function() {
            sidebar.classList.toggle('mobile-show');
        });
    }
    
    // 点击侧边栏外部关闭移动端侧边栏
    document.addEventListener('click', function(e) {
        if (sidebar && sidebar.classList.contains('mobile-show') && 
            !sidebar.contains(e.target) && 
            e.target !== mobileSidebarToggle &&
            !mobileSidebarToggle.contains(e.target)) {
            sidebar.classList.remove('mobile-show');
        }
    });
    
    // 移动端屏幕下关闭下拉菜单
    document.querySelectorAll('.navbar-nav .dropdown-menu').forEach(menu => {
        menu.addEventListener('click', function(e) {
            if (window.innerWidth < 992) {
                e.stopPropagation();
            }
        });
    });
    
    // 初始化工具提示
    const tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
    tooltipTriggerList.map(function (tooltipTriggerEl) {
        return new bootstrap.Tooltip(tooltipTriggerEl);
    });
    
    // 显示通知
    window.showNotification = function(message, type = 'info', duration = 3000) {
        const container = document.getElementById('notifications');
        if (!container) return;
        
        const notification = document.createElement('div');
        notification.className = `alert alert-${type} animate__animated animate__fadeIn`;
        notification.innerHTML = message;
        
        // 添加关闭按钮
        const closeBtn = document.createElement('button');
        closeBtn.type = 'button';
        closeBtn.className = 'btn-close';
        closeBtn.setAttribute('data-bs-dismiss', 'alert');
        closeBtn.setAttribute('aria-label', 'Close');
        notification.appendChild(closeBtn);
        
        container.appendChild(notification);
        
        // 自动关闭
        setTimeout(() => {
            notification.classList.remove('animate__fadeIn');
            notification.classList.add('animate__fadeOut');
            setTimeout(() => {
                notification.remove();
            }, 300);
        }, duration);
        
        // 点击关闭
        closeBtn.addEventListener('click', () => {
            notification.classList.remove('animate__fadeIn');
            notification.classList.add('animate__fadeOut');
            setTimeout(() => {
                notification.remove();
            }, 300);
        });
    };
    
    // 处理表单验证
    const forms = document.querySelectorAll('.needs-validation');
    Array.from(forms).forEach(form => {
        form.addEventListener('submit', event => {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
        }, false);
    });
}); 