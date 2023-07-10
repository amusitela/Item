import request from '@/utils/request'

// 查询userWork列表
export function listInsertsWork(query) {
  return request({
    url: '/clean/insertsWork/list',
    method: 'get',
    params: query
  })
}

// 查询userWork详细
export function getInsertsWork(num) {
  return request({
    url: '/clean/insertsWork/' + num,
    method: 'get'
  })
}

// 新增userWork
export function addInsertsWork(data) {
  return request({
    url: '/clean/insertsWork',
    method: 'post',
    data: data
  })
}

// 修改userWork
export function updateInsertsWork(data) {
  return request({
    url: '/clean/insertsWork',
    method: 'put',
    data: data
  })
}

// 删除userWork
export function delInsertsWork(num) {
  return request({
    url: '/clean/insertsWork/' + num,
    method: 'delete'
  })
}
