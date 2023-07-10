import request from '@/utils/request'

// 查询111列表
export function listPeople(query) {
  return request({
    url: '/system/people/list',
    method: 'get',
    params: query
  })
}

// 查询111详细
export function getPeople(kehuid) {
  return request({
    url: '/system/people/' + kehuid,
    method: 'get'
  })
}

// 新增111
export function addPeople(data) {
  return request({
    url: '/system/people',
    method: 'post',
    data: data
  })
}

// 修改111
export function updatePeople(data) {
  return request({
    url: '/system/people',
    method: 'put',
    data: data
  })
}

// 删除111
export function delPeople(kehuid) {
  return request({
    url: '/system/people/' + kehuid,
    method: 'delete'
  })
}
