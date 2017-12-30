/*
 * Copyright (C) 2017-present, Chenai Nakam(chenai.nakam@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package hobby.wei.c.persist.db

import com.fortysevendeg.mvessel.logging.LogWrapper
import hobby.chenai.nakam.basis.TAG
import hobby.wei.c.LOG

/**
  * @author Chenakam (chenai.nakam@gmail.com)
  * @version 1.0, 29/12/2017
  */
object DBLogWrapper extends LogWrapper with TAG.ClassName {
  override def d(msg: String): Unit = LOG.d(msg)

  override def e(msg: String, t: Option[Throwable]): Unit = t.fold(LOG.e(msg))(LOG.e(_, msg))

  override def i(msg: String): Unit = LOG.i(msg)

  override def v(msg: String): Unit = LOG.v(msg)

  override def w(msg: String): Unit = LOG.w(msg)
}