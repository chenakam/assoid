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

package hobby.wei.c.core

import android.os.Bundle
import android.view.{LayoutInflater, ViewGroup}
import androidx.fragment.app.Fragment
import hobby.wei.c.anno.inject.Injector

/**
  * @author Chenai Nakam(chenai.nakam@gmail.com)
  * @version 1.0, 17/11/2017
  */
object Inject {
  trait Acty extends AbsActy {
    override protected def onCreate(savedInstanceState: Bundle): Unit = {
      super.onCreate(savedInstanceState)
      Injector.inject(this, classOf[AbsActy])
    }
  }

  trait Fragmt extends Fragment {
    override def onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle) = {
      super.onCreateView(inflater, container, savedInstanceState)
      val view = inflater.inflate(Injector.layoutID(getActivity, getClass), container, false)
      Injector.inject(this, view, classOf[Fragmt])
      view
    }
  }
}
