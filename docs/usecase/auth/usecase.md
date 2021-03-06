# 認証・認可コンテキスト

## 前提条件

- ユーザとクライアントの登録画面は別なURLで別れているものとする
- 現状では、「パスワードリセット」「退会」は、含まないものとする

## ユーザー(応募者)登録

|タイトル|内容|
| :--- |:---|
|ユースケース名| ユーザ登録|
|目的| 求人応募システムを利用するためにユーザ登録を行うこと|
|アクター| ユーザー |
|画面| ユーザ登録画面 |
|前提条件| 登録済みではないこと|
|メインフロー| 1. ユーザーは、「ユーザ登録画面」へ遷移する<br> 2. ユーザは、「メールアドレス」もしくは「ログインに利用するSNSアカウントを利用する」<br> 3. 仮登録が完了し、登録したメールアドレスへ本登録案内メールが届く|
|代替フロー| Alt1. すでに登録済みの場合 <br> 1.「すでに登録済みです」というメッセージを表示する。 | 


## クライアント(募集者)登録

|タイトル|内容|
| :--- |:---|
|ユースケース名| クライアント登録|
|目的| 求人募集システムを利用するためにユーザ登録を行うこと|
|アクター| クライアント|
|前提条件| 登録済みではないこと|
|メインフロー| 1. クライアントは、「クライアント登録画面」へ遷移する <br> 2. クライアントは、「メールアドレス」を入力する <br> 3.登録されたメールアドレスに本登録案内メールが届く |
|代替フロー| Alt1. すでに登録済みの場合 <br> 1. 「すでに登録済みです」というメッセージを表示する

## ユーザーログイン

|タイトル|内容|
| :--- |:---|
|ユースケース名| ログイン |
|目的| 求人応募システムを利用するためにログインを行うこと|
|アクター| ユーザー |
|前提条件| 会員登録済みであること |
|メインフロー| 1. ユーザーは「ログイン画面」へ移動する <br> 2. ユーザーは、登録した「メールアドレス・パスワード」を入力もしくはSNSアカウントを選択する <br> 3. ダッシュボードへ遷移する|
|代替フロー| Alt1. メールアドレスもしくはパスワードが間違っている<br>1. 「メールアドレスもしくはパスワードに誤りがあります」と表示する<br> Alt2. 選択したSNSアカウントで会員登録をしていない場合 <br> 1. 本登録画面へ遷移させる |

## クライアントログイン

|タイトル|内容|
| :--- | :--- |
|ユースケース名| クライアントログイン|
|目的| 求人募集システムを利用するためにログインを行うこと|
|アクター| クライアント |
|前提条件| 会員登録済みであること |
|メインフロー| 1. クライアントは「ログイン画面へ移動する <br> 2. クライアントは、登録した「メールアドレス・パスワード」を入力する <br> 3. ログインに成功しダッシュボードへ遷移する |
|代替フロー| Alt1. メールアドレスもしくはパスワードが間違っている <br> 1. 「メールアドレスもしくはパスワードに誤りがあります」と表示する |
