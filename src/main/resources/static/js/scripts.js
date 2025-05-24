// 智能制造存储中心系统 - 交互脚本

document.addEventListener('DOMContentLoaded', function() {
    // 初始化Bootstrap工具提示
    var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
    var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
        return new bootstrap.Tooltip(tooltipTriggerEl);
    });

    // 激活当前导航链接
    activateCurrentNavLink();
    
    // 为表格添加动画效果
    animateTableRows();
    
    // 处理侧边栏折叠
    setupSidebar();
    
    // 初始化表单验证
    setupFormValidation();
    
    // 表格搜索和过滤功能
    setupTableSearch();
});

/**
 * 激活当前导航链接
 */
function activateCurrentNavLink() {
    const currentPath = window.location.pathname;
    const navLinks = document.querySelectorAll('.sidebar .list-group-item, .navbar .nav-link');
    
    navLinks.forEach(link => {
        const href = link.getAttribute('href');
        if (href && (currentPath === href || currentPath.startsWith(href + '/'))) {
            link.classList.add('active');
            
            // 如果是在侧边栏中，确保其可见
            if (link.closest('.sidebar')) {
                link.scrollIntoView({ behavior: 'smooth', block: 'center' });
            }
        }
    });
}

/**
 * 为表格添加动画效果
 */
function animateTableRows() {
    const tableRows = document.querySelectorAll('tbody tr');
    
    tableRows.forEach((row, index) => {
        // 添加延迟动画效果
        row.style.opacity = '0';
        row.style.transform = 'translateY(10px)';
        row.style.transition = 'opacity 0.3s ease, transform 0.3s ease';
        row.style.transitionDelay = `${index * 0.05}s`;
        
        setTimeout(() => {
            row.style.opacity = '1';
            row.style.transform = 'translateY(0)';
        }, 100);
    });
    
    // 为可点击行添加点击效果
    const clickableRows = document.querySelectorAll('tr[data-bs-toggle="collapse"]');
    clickableRows.forEach(row => {
        row.addEventListener('click', function(e) {
            // 忽略点击按钮的情况
            if (e.target.closest('a, button')) {
                e.stopPropagation();
                return;
            }
            
            // 切换箭头图标方向
            const target = this.getAttribute('data-bs-target');
            const isExpanded = this.getAttribute('aria-expanded') === 'true';
            this.setAttribute('aria-expanded', !isExpanded);
        });
    });
}

/**
 * 设置侧边栏折叠功能
 */
function setupSidebar() {
    const sidebarToggle = document.getElementById('sidebar-toggle');
    const sidebar = document.querySelector('.sidebar');
    
    if (sidebarToggle && sidebar) {
        sidebarToggle.addEventListener('click', function() {
            sidebar.classList.toggle('collapsed');
            
            // 保存用户偏好
            const isCollapsed = sidebar.classList.contains('collapsed');
            localStorage.setItem('sidebar-collapsed', isCollapsed);
        });
        
        // 恢复用户偏好
        const isCollapsed = localStorage.getItem('sidebar-collapsed') === 'true';
        if (isCollapsed) {
            sidebar.classList.add('collapsed');
        }
    }
    
    // 移动设备上的侧边栏
    const mobileToggle = document.getElementById('mobile-sidebar-toggle');
    if (mobileToggle && sidebar) {
        mobileToggle.addEventListener('click', function() {
            sidebar.classList.toggle('mobile-show');
        });
        
        // 点击内容区域关闭侧边栏
        document.querySelector('.content').addEventListener('click', function() {
            if (window.innerWidth < 768) {
                sidebar.classList.remove('mobile-show');
            }
        });
    }
}

/**
 * 设置表单验证
 */
function setupFormValidation() {
    const forms = document.querySelectorAll('.needs-validation');
    
    Array.from(forms).forEach(form => {
        form.addEventListener('submit', event => {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
                
                // 提示第一个无效字段
                const invalidField = form.querySelector(':invalid');
                if (invalidField) {
                    invalidField.focus();
                }
            }
            
            form.classList.add('was-validated');
        }, false);
    });
}

/**
 * 设置表格搜索和过滤
 */
function setupTableSearch() {
    const searchInput = document.getElementById('table-search');
    if (!searchInput) return;
    
    searchInput.addEventListener('keyup', function() {
        const searchText = this.value.toLowerCase();
        const table = document.querySelector('table');
        const rows = table.querySelectorAll('tbody tr');
        
        rows.forEach(row => {
            const textContent = row.textContent.toLowerCase();
            const isVisible = textContent.indexOf(searchText) > -1;
            row.style.display = isVisible ? '' : 'none';
        });
        
        // 更新结果计数
        const visibleCount = [...rows].filter(row => row.style.display !== 'none').length;
        const countElement = document.getElementById('search-result-count');
        if (countElement) {
            countElement.textContent = `${visibleCount} 项结果`;
        }
    });
    
    // 类型过滤
    const typeFilters = document.querySelectorAll('.type-filter');
    typeFilters.forEach(filter => {
        filter.addEventListener('click', function() {
            const type = this.getAttribute('data-type');
            const table = document.querySelector('table');
            const rows = table.querySelectorAll('tbody tr');
            
            rows.forEach(row => {
                if (type === 'all') {
                    row.style.display = '';
                } else {
                    const rowType = row.getAttribute('data-type');
                    row.style.display = rowType === type ? '' : 'none';
                }
            });
            
            // 更新激活状态
            typeFilters.forEach(f => f.classList.remove('active'));
            this.classList.add('active');
        });
    });
}

/**
 * 显示确认对话框
 * @param {string} message 确认消息
 * @param {Function} callback 确认后的回调函数
 */
function confirmAction(message, callback) {
    if (window.confirm(message)) {
        callback();
    }
}

/**
 * 显示通知提示
 * @param {string} message 通知消息
 * @param {string} type 通知类型 (success, error, warning, info)
 */
function showNotification(message, type = 'info') {
    const container = document.getElementById('notifications') || document.createElement('div');
    
    if (!document.getElementById('notifications')) {
        container.id = 'notifications';
        container.className = 'notification-container';
        document.body.appendChild(container);
    }
    
    const notification = document.createElement('div');
    notification.className = `notification notification-${type} fade-in`;
    
    const icon = document.createElement('i');
    switch (type) {
        case 'success': icon.className = 'fas fa-check-circle'; break;
        case 'error': icon.className = 'fas fa-exclamation-circle'; break;
        case 'warning': icon.className = 'fas fa-exclamation-triangle'; break;
        default: icon.className = 'fas fa-info-circle';
    }
    
    const textSpan = document.createElement('span');
    textSpan.textContent = message;
    
    notification.appendChild(icon);
    notification.appendChild(textSpan);
    container.appendChild(notification);
    
    // 自动关闭
    setTimeout(() => {
        notification.classList.add('fade-out');
        setTimeout(() => {
            container.removeChild(notification);
        }, 300);
    }, 5000);
} 