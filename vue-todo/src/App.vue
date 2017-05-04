<template>
  <div id="app" class="container">
    <div class="row">
      <form class="col-md-6 col-md-offset-1">
        <div class="form-group">
          <label for="nome">Nome</label>
          <input type="text" class="form-control" id="nome" placeholder="Digite o nome"
          v-model="member.name">
        </div>
        <div class="form-group">
          <label for="idade">Idade</label>
          <input type="text" class="form-control" id="idade" placeholder="Digite a idade"
          v-model="member.age">
        </div>

        <button type="button" class="btn btn-primary"
        v-on:click="editing ? updateMember(member) : createMember(member)">
        Salvar
      </button>

      <button type="button" class="btn btn-danger"
      v-on:click="cleanMember()">
      Cancelar
    </button>
  </form>

  <div class="col-md-6 col-md-offset-3 group-form">
    <label for="search">Pesquisar</label>
    <input type="text" id="search" class="form-control" placeholder="Pesquisar Colaborador">
  </div>

  <div class="col-md-6 col-md-offset-1">
    <table class="table table-hover">
      <thead>
        <tr>
          <th>Nome</th>
          <th>Idade</th>
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="m in members">
          <td >{{m.name}}</td>
          <td >{{m.age}}</td>
          <td>
            <button type="button" name="editar" class="btn btn-warning"
            v-on:click="editMember(m)">
            Editar
          </button>
        </td>
        <td>
          <button type="button" name="cancelar" class="btn btn-danger"
          v-on:click="deleteMember(m)">
          Excluir
        </button>
      </td>
    </tr>
  </tbody>
</table>
</div>

</div>
</div>
</template>

<script>
const apiUrl = 'https://todo-spring-boot-testit.herokuapp.com/';

export default {
  name: 'app',
  data () {
    return {
      member: {
        name: '',
        age: ''
      },
      members: [],
      editing: false,
      memberUrl: '' //TODO: Check if this is the best way
    }
  },
  created() {
    this.getMembers();
  },
  methods: {
    cleanMember() { //TODO: Refactoring
      this.member.name = '';
      this.member.age = '';
      this.memberUrl = '';
      this.editing = false;
    },
    getMembers() {
      this.$http.get(`${apiUrl}/member`)
      .then((d) => {
        this.members = d.data._embedded.member;
      })
      .catch((e) => {
        console.log(e);
      });
    },
    createMember(member) {
      this.$http.post(`${apiUrl}/member`, member)
      .then(data => {
        this.cleanMember();
        this.getMembers();
      }, e => {
        console.log(e);
      });
    },
    editMember(member) { //TODO: Refactoring
      this.editing = true;
      this.memberUrl = member._links.self.href;
      this.member = cloneObj(member);
    },
    updateMember(member) {
      this.$http.put(this.memberUrl, member)
      .then(data => {
        this.cleanMember();
        this.getMembers();
      }, e => {
        console.log(e);
      });
    },
    deleteMember(member) {
      this.memberUrl = member._links.self.href; //TODO: Refactoring
      this.$http.delete(this.memberUrl)
      .then(data => {
        this.getMembers();
      }, e => {
        console.log(e);
      });
    }
  }
}

function cloneObj(object) {
  return JSON.parse(JSON.stringify(object));
}

</script>

<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  //text-align: center;
  //color: #2c3e50;
  margin-top: 15vh;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
