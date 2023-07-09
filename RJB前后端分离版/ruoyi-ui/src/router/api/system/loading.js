import request from '@/utils/request'

// 查询装货表列表
export function listLoading(query) {
  return request({
    url: '/system/loading/list',
    method: 'get',
    params: query
  })
}

// 查询装货表详细
export function getLoading(id) {
  return request({
    url: '/system/loading/' + id,
    method: 'get'
  })
}

// 新增装货表
export function addLoading(data) {
  return request({
    url: '/system/loading',
    method: 'post',
    data: data
  })
}

// 修改装货表
export function updateLoading(data) {
  return request({
    url: '/system/loading',
    method: 'put',
    data: data
  })
}

// 删除装货表
export function delLoading(id) {
  return request({
    url: '/system/loading/' + id,
    method: 'delete'
  })
}
