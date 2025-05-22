<script setup>
import {reactive, onMounted, watch} from "vue";
import {getItems, removeItem} from "@/services/cartService.js";
import router from "@/router/index.js";

// 상태
const state = reactive({
  items: []
});

// 주문하기
const order = async () => {

  await router.push("/orders");
};


// 생성 훅
(async function onCreated() {
  const res = await getItems();
  if (res.status === 200) {
    console.log(res.data);
    state.items = res.data;
  }
})();


const remove = async (itemId) => {
  await removeItem(itemId);
  const res = await getItems();
  if(res.status === 200)
    console.log(res.data);
  state.items = res.data;
};


</script>

<template>
  <div class="cart">
    <div class="container">
      <template v-if="state.items.length > 0">
        <ul class="items">
          <li v-for="item in state.items" :key="item.id">
            <img :src="item.imgPath" />
            <b class="name">{{ item.name }}</b>
            <span class="price">
          {{ (item.price - (item.price * item.discountPer / 100)).toLocaleString() }}원
          </span>
            <span class="remove float-end" title="삭제" @click="remove(item.id)">&times;</span>
          </li>
        </ul>
        <div class="act">
          <button class="btn btn-primary" @click="order()">주문하기</button>
        </div>
      </template>
      <div class="text-center py-5" v-else>장바구니가 비어있습니다.</div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.cart {
  .items {
    list-style: none;
    margin: 0;
    padding: 0;

    li {
      border: 1px solid #eee;
      margin-top: 25px;
      margin-bottom: 25px;
    }

    img {
      width: 150px;
      height: 150px;
    }

    .name {
      margin-left: 25px;
    }

    .price {
      margin-left: 25px;
    }

    .remove {
      cursor: pointer;
      font-size: 30px;
      padding: 5px 15px;
    }
  }

  .act .btn {
    width: 300px;
    display: block;
    margin: 0 auto;
    padding: 30px 50px;
    font-size: 20px;
  }
}
</style>



