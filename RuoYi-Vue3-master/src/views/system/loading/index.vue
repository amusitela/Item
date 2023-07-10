<template>
  
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="船名" prop="boatname">
        <el-input
          v-model="queryParams.boatname"
          placeholder="请输入船名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="作业开始时间" prop="begining">
        <el-input
          v-model="queryParams.begining"
          placeholder="请输入作业开始时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="作业结束时间" prop="ending">
        <el-input
          v-model="queryParams.ending"
          placeholder="请输入作业结束时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="始发时间" prop="origintime">
        <el-input
          v-model="queryParams.origintime"
          placeholder="请输入始发时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="到达时间" prop="arrivetime">
        <el-input
          v-model="queryParams.arrivetime"
          placeholder="请输入到达时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="作业港口" prop="workport">
        <el-input
          v-model="queryParams.workport"
          placeholder="请输入作业港口"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="提单号" prop="ladnum">
        <el-input
          v-model="queryParams.ladnum"
          placeholder="请输入提单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="集装箱箱号" prop="boxnum">
        <el-input
          v-model="queryParams.boxnum"
          placeholder="请输入集装箱箱号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="箱尺寸" prop="boxsize">
        <el-input
          v-model="queryParams.boxsize"
          placeholder="请输入箱尺寸"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="启运地" prop="originaddress">
        <el-input
          v-model="queryParams.originaddress"
          placeholder="请输入启运地"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="目的地" prop="destination">
        <el-input
          v-model="queryParams.destination"
          placeholder="请输入目的地"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="船公司" prop="boatcompany">
        <el-input
          v-model="queryParams.boatcompany"
          placeholder="请输入船公司"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['system:loading:add']"
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
          v-hasPermi="['system:loading:edit']"
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
          v-hasPermi="['system:loading:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:loading:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="loadingList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="船名" align="center" prop="boatname" />
      <el-table-column label="作业开始时间" align="center" prop="begining" />
      <el-table-column label="作业结束时间" align="center" prop="ending" />
      <el-table-column label="始发时间" align="center" prop="origintime" />
      <el-table-column label="到达时间" align="center" prop="arrivetime" />
      <el-table-column label="作业港口" align="center" prop="workport" />
      <el-table-column label="提单号" align="center" prop="ladnum" />
      <el-table-column label="集装箱箱号" align="center" prop="boxnum" />
      <el-table-column label="箱尺寸" align="center" prop="boxsize" />
      <el-table-column label="启运地" align="center" prop="originaddress" />
      <el-table-column label="目的地" align="center" prop="destination" />
      <el-table-column label="船公司" align="center" prop="boatcompany" />
      <el-table-column label="操作" align="center" width="200" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button
            size="mini"
            type="primary"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:Kehu:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="primary"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:Kehu:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改装货表对话框 -->
    <el-dialog :title="title" v-model="open" width="650px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="船名" prop="boatname">
          <el-input v-model="form.boatname" placeholder="请输入船名" />
        </el-form-item>
        <el-form-item label="作业开始时间" prop="begining">
          <el-input v-model="form.begining" placeholder="请输入作业开始时间" />
        </el-form-item>
        <el-form-item label="作业结束时间" prop="ending">
          <el-input v-model="form.ending" placeholder="请输入作业结束时间" />
        </el-form-item>
        <el-form-item label="始发时间" prop="origintime">
          <el-input v-model="form.origintime" placeholder="请输入始发时间" />
        </el-form-item>
        <el-form-item label="到达时间" prop="arrivetime">
          <el-input v-model="form.arrivetime" placeholder="请输入到达时间" />
        </el-form-item>
        <el-form-item label="作业港口" prop="workport">
          <el-input v-model="form.workport" placeholder="请输入作业港口" />
        </el-form-item>
        <el-form-item label="提单号" prop="ladnum">
          <el-input v-model="form.ladnum" placeholder="请输入提单号" />
        </el-form-item>
        <el-form-item label="集装箱箱号" prop="boxnum">
          <el-input v-model="form.boxnum" placeholder="请输入集装箱箱号" />
        </el-form-item>
        <el-form-item label="箱尺寸" prop="boxsize">
          <el-input v-model="form.boxsize" placeholder="请输入箱尺寸" />
        </el-form-item>
        <el-form-item label="启运地" prop="originaddress">
          <el-input v-model="form.originaddress" placeholder="请输入启运地" />
        </el-form-item>
        <el-form-item label="目的地" prop="destination">
          <el-input v-model="form.destination" placeholder="请输入目的地" />
        </el-form-item>
        <el-form-item label="船公司" prop="boatcompany">
          <el-input v-model="form.boatcompany" placeholder="请输入船公司" />
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
import { listLoading, getLoading, delLoading, addLoading, updateLoading } from "@/api/system/loading";

export default {
  name: "Loading",
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
      // 装货表表格数据
      loadingList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        boatname: null,
        begining: null,
        ending: null,
        origintime: null,
        arrivetime: null,
        workport: null,
        ladnum: null,
        boxnum: null,
        boxsize: null,
        originaddress: null,
        destination: null,
        boatcompany: null,
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
    /** 查询装货表列表 */
    getList() {
      this.loading = true;
      listLoading(this.queryParams).then(response => {
        this.loadingList = response.rows;
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
        boatname: null,
        begining: null,
        ending: null,
        origintime: null,
        arrivetime: null,
        workport: null,
        ladnum: null,
        boxnum: null,
        boxsize: null,
        originaddress: null,
        destination: null,
        boatcompany: null,
        id: null
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加装货表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getLoading(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改装货表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateLoading(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLoading(this.form).then(response => {
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
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除装货表编号为"' + ids + '"的数据项？').then(function() {
        return delLoading(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/loading/export', {
        ...this.queryParams
      }, `loading_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
