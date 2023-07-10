<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="流水号" prop="num">
        <el-input
          v-model="queryParams.num"
          placeholder="请输入流水号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="堆存港口" prop="port">
        <el-input
          v-model="queryParams.port"
          placeholder="请输入堆存港口"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="集装箱箱号" prop="containerNum">
        <el-input
          v-model="queryParams.containerNum"
          placeholder="请输入集装箱箱号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="箱尺寸" prop="cc">
        <el-input
          v-model="queryParams.cc"
          placeholder="请输入箱尺寸"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="提单号" prop="tNum">
        <el-input
          v-model="queryParams.tNum"
          placeholder="请输入提单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="堆场位置" prop="place">
        <el-input
          v-model="queryParams.place"
          placeholder="请输入堆场位置"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="操作" prop="status">
        <el-input
          v-model="queryParams.status"
          placeholder="请输入操作"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="操作日期" prop="date">
        <el-date-picker clearable
          v-model="queryParams.date"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择操作日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['clean:insertContainer:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['clean:insertContainer:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['clean:insertContainer:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['clean:insertContainer:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="insertContainerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="流水号" align="center" prop="num" />
      <el-table-column label="堆存港口" align="center" prop="port" />
      <el-table-column label="集装箱箱号" align="center" prop="containerNum" />
      <el-table-column label="箱尺寸" align="center" prop="cc" />
      <el-table-column label="提单号" align="center" prop="tNum" />
      <el-table-column label="堆场位置" align="center" prop="place" />
      <el-table-column label="操作" align="center" prop="status" />
      <el-table-column label="操作日期" align="center" prop="date" width="180" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['clean:insertContainer:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['clean:insertContainer:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
                      v-show="total>0"
                      :total="total"
                      v-model:page="queryParams.pageNum"
                      v-model:limit="queryParams.pageSize"
                      @pagination="getList"
                    />

    <!-- 添加或修改userContainer对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="流水号" prop="num">
          <el-input v-model="form.num" placeholder="请输入流水号" />
        </el-form-item>
        <el-form-item label="堆存港口" prop="port">
          <el-input v-model="form.port" placeholder="请输入堆存港口" />
        </el-form-item>
        <el-form-item label="集装箱箱号" prop="containerNum">
          <el-input v-model="form.containerNum" placeholder="请输入集装箱箱号" />
        </el-form-item>
        <el-form-item label="箱尺寸" prop="cc">
          <el-input v-model="form.cc" placeholder="请输入箱尺寸" />
        </el-form-item>
        <el-form-item label="提单号" prop="tNum">
          <el-input v-model="form.tNum" placeholder="请输入提单号" />
        </el-form-item>
        <el-form-item label="堆场位置" prop="place">
          <el-input v-model="form.place" placeholder="请输入堆场位置" />
        </el-form-item>
        <el-form-item label="操作" prop="status">
          <el-input v-model="form.status" placeholder="请输入操作" />
        </el-form-item>
        <el-form-item label="操作日期" prop="date">
          <el-date-picker clearable
            v-model="form.date"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择操作日期">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listInsertContainer, getInsertContainer, delInsertContainer, addInsertContainer, updateInsertContainer } from "@/api/clean/insertContainer";

export default {
  name: "InsertContainer",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // userContainer表格数据
      insertContainerList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      flag:0,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        num: null,
        port: null,
        containerNum: null,
        cc: null,
        tNum: null,
        place: null,
        status: null,
        date: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询userContainer列表 */
    getList() {
      this.loading = true;
      listInsertContainer(this.queryParams).then(response => {
        this.insertContainerList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        num: null,
        port: null,
        containerNum: null,
        cc: null,
        tNum: null,
        place: null,
        status: null,
        date: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.num)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
    this.flag=1
      this.reset();
      this.open = true;
      this.title = "添加userContainer";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
        this.flag=0
      this.reset();
      const num = row.num || this.ids
      getInsertContainer(num).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改userContainer";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.flag== 0) {
            updateInsertContainer(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInsertContainer(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const nums = row.num || this.ids;
      this.$modal.confirm('是否确认删除userContainer编号为"' + nums + '"的数据项？').then(function() {
        return delInsertContainer(nums);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('clean/insertContainer/export', {
        ...this.queryParams
      }, `insertContainer_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
