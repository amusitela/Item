import request from '@/utils/request'


// 查询work列表
export function listWORK(query) {
  return request({
    url: '/clean/WORK/list',
    method: 'get',
    params: query
  })
}

// 查询work详细
export function getWORK(num) {
  return request({
    url: '/clean/WORK/' + num,
    method: 'get'
  })
}

// 新增work
export function addWORK(data) {
  return request({
    url: '/clean/WORK',
    method: 'post',
    data: data
  })
}

// 修改work
export function updateWORK(data) {
  return request({
    url: '/clean/WORK',
    method: 'put',
    data: data
  })
}

// 删除work
export function delWORK(num) {
  return request({
    url: '/clean/WORK/' + num,
    method: 'delete'
  })
}
