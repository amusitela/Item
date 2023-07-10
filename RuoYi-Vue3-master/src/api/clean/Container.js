import request from '@/utils/request'


// 查询Container列表
export function listContainer(query) {
  return request({
    url: '/clean/Container/list',
    method: 'get',
    params: query
  })
}

// 查询Container详细
export function getContainer(num) {
  return request({
    url: '/clean/Container/' + num,
    method: 'get'
  })
}

// 新增Container
export function addContainer(data) {
  return request({
    url: '/clean/Container',
    method: 'post',
    data: data
  })
}

// 修改Container
export function updateContainer(data) {
  return request({
    url: '/clean/Container',
    method: 'put',
    data: data
  })
}

// 删除Container
export function delContainer(num) {
  return request({
    url: '/clean/Container/' + num,
    method: 'delete'
  })
}
