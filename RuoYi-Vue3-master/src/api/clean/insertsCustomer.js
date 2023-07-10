import request from '@/utils/request'

// 查询userCustomer列表
export function listInsertsCustomer(query) {
  return request({
    url: '/clean/insertsCustomer/list',
    method: 'get',
    params: query
  })
}

// 查询userCustomer详细
export function getInsertsCustomer(num) {
  return request({
    url: '/clean/insertsCustomer/' + num,
    method: 'get'
  })
}

// 新增userCustomer
export function addInsertsCustomer(data) {
  return request({
    url: '/clean/insertsCustomer',
    method: 'post',
    data: data
  })
}

// 修改userCustomer
export function updateInsertsCustomer(data) {
  return request({
    url: '/clean/insertsCustomer',
    method: 'put',
    data: data
  })
}

// 删除userCustomer
export function delInsertsCustomer(num) {
  return request({
    url: '/clean/insertsCustomer/' + num,
    method: 'delete'
  })
}
